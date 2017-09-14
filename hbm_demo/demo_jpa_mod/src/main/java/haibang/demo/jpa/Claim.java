package haibang.demo.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CLAIM database table.
 * 
 */
@Entity
@NamedQueries(value= {
		@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c"),
		@NamedQuery(name="Claim.findByPerson", query="SELECT c FROM Claim c WHERE c.person.personId=:personId"), 
		@NamedQuery(name="Claim.findByAmountRange", query="SELECT c FROM Claim c WHERE c.amount BETWEEN :x AND  :y")
})
public class Claim implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2042516269019690662L;

	@Id
	@SequenceGenerator(name="CLAIM_CLAIMID_GENERATOR",initialValue=1, allocationSize=1, sequenceName="CLAIM_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLAIM_CLAIMID_GENERATOR")
	@Column(name="CLM_ID", updatable=false, length=9)
	private String claimId;

	@Column(name="CLM_DESC", length=80)
	private String description;

	@Column(name="CLM_STAT", length=6)
	private String status;
	
	@Column(name="CLM_AMOUNT", precision=9)
	private Float amount;
	
	@Embedded
	private Audit audit;
	
	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLM_PERS")
	private Person person;

	public Claim() {
	}

	public String getClaimId() {
		return this.claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public float getAmount()
	{
		return amount;
	}

	public void setAmount(float amount)
	{
		this.amount = amount;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
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