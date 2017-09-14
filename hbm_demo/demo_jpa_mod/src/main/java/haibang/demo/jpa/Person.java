package haibang.demo.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@NamedQueries(value= {
		@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p"), 
		@NamedQuery(name="Person.findLikeName", query="SELECT p FROM Person p WHERE p.familyName LIKE :familyName OR p.firstName LIKE :firstName"),
		@NamedQuery(name="Person.findHaveClaims", query="SELECT p FROM Person p WHERE (SELECT count(c) FROM Claim c WHERE p=c.person) >  0")
})
public class Person implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3976695620024141586L;

	@Id
	@SequenceGenerator(name = "PERSON_PERSONID_GENERATOR", initialValue=1, allocationSize=1, sequenceName = "PERSON_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_PERSONID_GENERATOR")
	@Column(name = "PER_ID", updatable = false, length=9)
	private String personId;

	@Column(name = "EMAIL", length=20)
	private String emailAddress;

	@Column(name = "FAMILY_NM", length=20)
	private String familyName;

	@Column(name = "FIRST_NM", length=20)
	private String firstName;

	@Column(name = "MOBILE_NUM", length=10)
	private String mobileNumber;

	@Column(name = "PHONE_NUM", length=10)
	private String phoneNumber;

	@Embedded
	private Audit audit;
	// bi-directional many-to-one association to Claim
	@OneToMany(mappedBy = "person")
	private List<Claim> claims;

	public Person()
	{
	}

	public String getPersonId()
	{
		return this.personId;
	}

	public void setPersonId(String personId)
	{
		this.personId = personId;
	}

	public String getEmailAddress()
	{
		return this.emailAddress;
	}

	public void setEmailAddress(String email)
	{
		this.emailAddress = email;
	}

	public String getFamilyName()
	{
		return this.familyName;
	}

	public void setFamilyName(String familyName)
	{
		this.familyName = familyName;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getMobileNumber()
	{
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public List<Claim> getClaims()
	{
		return this.claims;
	}

	public void setClaims(List<Claim> claims)
	{
		this.claims = claims;
	}

	public Claim addClaim(Claim claim)
	{
		getClaims().add(claim);
		claim.setPerson(this);

		return claim;
	}

	public Claim removeClaim(Claim claim)
	{
		getClaims().remove(claim);
		claim.setPerson(null);

		return claim;
	}

	public Audit getAudit()
	{
		return audit;
	}

	public void setAudit(Audit audit)
	{
		this.audit = audit;
	}

}