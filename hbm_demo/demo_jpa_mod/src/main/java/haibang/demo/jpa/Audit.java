package haibang.demo.jpa;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class Audit
{
	@Column(name="CRT_DT")
	private Timestamp createdDate;

	@Column(name="CRT_USR", length=10)
	private String createdUser;

	@Column(name="UPD_DT")
	private Timestamp updatedDate;

	@Column(name="UPD_USR", length=10)
	private String updatedUser;

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getCreatedUser()
	{
		return createdUser;
	}

	public void setCreatedUser(String createdUser)
	{
		this.createdUser = createdUser;
	}

	public Timestamp getUpdatedDate()
	{
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate)
	{
		this.updatedDate = updatedDate;
	}

	public String getUpdatedUser()
	{
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser)
	{
		this.updatedUser = updatedUser;
	}

}
