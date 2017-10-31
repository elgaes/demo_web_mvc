package au.gov.dva.digitize.document.test;

import java.io.File;

import javax.xml.bind.JAXB;

import au.gov.dva.digitize.document.jaxb.MailMeta;

public class MailMetaReader {

	public static void main(String[] args) 
	{
		try {
			MailMeta mail=JAXB.unmarshal(new File(args[0]+"/ReceivedMailMeta.xml"), MailMeta.class);
			print(mail);
		}catch(Throwable e) {
			System.err.println("ERROR: "+e.toString());
		}
	}
	public static void print(MailMeta mail)
	{
		System.out.println("doc_id="+mail.getDocId()+"; env_id="+mail.getEnvelopeId()+"; bag_id="+mail.getBagId()+"; filename="+mail.getFileName()+"; trim_ref="+mail.getTrimRef());
	}
}
