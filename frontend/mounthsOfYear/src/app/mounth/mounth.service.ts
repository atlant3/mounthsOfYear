import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Mounth } from "./mounth";
import { HttpClient } from '@angular/common/http';
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class MounthService {

    private serverUrl = environment.baseUrl;

    constructor(private http: HttpClient) {

    }

    public getMounths(): Observable<Mounth[]> {
        return this.http.get<Mounth[]>(`${this.serverUrl}/mounths/all`);
    }
    public addMounth(mounth:Mounth): Observable<Mounth> {
        return this.http.post<Mounth>(`${this.serverUrl}/mounths/add`, mounth);
    }
    public updateMounth(mounth:Mounth): Observable<Mounth> {
        return this.http.put<Mounth>(`${this.serverUrl}/mounths/update`, mounth);
    }
    public deleteMounth(id:number): Observable<void> {
        return this.http.delete<void>(`${this.serverUrl}/mounths/delete/${id}`);
    }
}