import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { Mounth } from './mounth';
import { MounthService } from './mounth.service';
import { FormsModule, NgForm } from '@angular/forms';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';


@Component({

  selector: 'app-mounth',
  templateUrl: './mounth.component.html',
  styleUrls: ['./mounth.component.css']
})

export class MounthComponent implements OnInit {
  chekedItem: number = -1;
  mounths: Mounth[];
  editMounth: Mounth;
  searchKey: string;
  modalRef?: BsModalRef;
  constructor(private mounthService: MounthService, private modalService: BsModalService) {

  }

  ngOnInit(): void {
    this.getMounths();

  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  getMounths(): void {
    this.mounthService.getMounths().subscribe(
      (response: Mounth[]) => {
        this.mounths = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }
  deleteMounth(id: number): void {
    let confirmDelete = confirm("Видалити місяць з таблиці?")
    if(confirmDelete == true) {
      this.mounthService.deleteMounth(id).subscribe(
        (response: void) => {
          console.log(response);
          this.searchMounths(this.searchKey);
  
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
  
      );
    }
    

  }

  addMounth(addForm: NgForm): void {
    this.mounthService.addMounth(addForm.value).subscribe(
      (response: Mounth) => {
        console.log(response);
        this.searchMounths(this.searchKey);
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  updateMounth(mounth: Mounth): void {
    this.mounthService.updateMounth(mounth).subscribe(
      (response: Mounth) => {
        console.log(response);
        this.searchMounths(this.searchKey);

      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  showUpdateModal(template: TemplateRef<any>, id: number) {
    for (let mounth of this.mounths) {
      if (mounth.id == id) {
        this.editMounth = mounth;
      }
    }
    this.openModal(template);
  }
  searchMounths(key: string): void {

    this.getMounths();
    setTimeout(() => {
      const results: Mounth[] = [];
      for (const mounth of this.mounths) {
        if (mounth.active == true) {
          if (mounth.name.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
            results.push(mounth);
          }
        }
      }
      this.mounths = results;

    }, 100);
  }



}
