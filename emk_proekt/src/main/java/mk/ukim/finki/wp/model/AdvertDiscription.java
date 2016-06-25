package mk.ukim.finki.wp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "advertDescription")
@Indexed
public class AdvertDiscription extends BaseEntity {

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String typeOfDeal;
	
	private int dailyWorkingHours;
	
	private int weekWorkingHours;
	
	private String workTime;
	
	private int basicSalary;
	
	@Column(length = 1000)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String optionalDescription;

	public String getOptionalDescription() {
		return optionalDescription;
	}

	public void setOptionalDescription(String optionalDescription) {
		this.optionalDescription = optionalDescription;
	}

	public String getTypeOfDeal() {
		return typeOfDeal;
	}

	public void setTypeOfDeal(String typeOfDeal) {
		this.typeOfDeal = typeOfDeal;
	}

	public int getDailyWorkingHours() {
		return dailyWorkingHours;
	}

	public void setDailyWorkingHours(int dailyWorkingHours) {
		this.dailyWorkingHours = dailyWorkingHours;
	}

	public int getWeekWorkingHours() {
		return weekWorkingHours;
	}

	public void setWeekWorkingHours(int weekWorkingHours) {
		this.weekWorkingHours = weekWorkingHours;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	@Override
	public String toString() {
		return "ADVERT DESCRIPTION" + typeOfDeal + " " + optionalDescription;
	}
	
	
	
}
