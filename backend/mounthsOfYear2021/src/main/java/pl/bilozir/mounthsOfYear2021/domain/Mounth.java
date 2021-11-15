package pl.bilozir.mounthsOfYear2021.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mounths")
public class Mounth {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int number;
	private String name;
	private boolean active;
	public Mounth(int number, String name, boolean isActive) {
		this.number = number;
		this.name = name;
		this.active = isActive;
	}
	public Mounth(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public Mounth() {
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean isActive) {
		this.active = isActive;
	}
	public long getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mounth other = (Mounth) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mounth [id=" + id + ", number=" + number + ", name=" + name + ", isActive=" + active + "]";
	}
	
	
	
	
}
