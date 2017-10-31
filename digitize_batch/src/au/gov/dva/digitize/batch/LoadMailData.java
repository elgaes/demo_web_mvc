package au.gov.dva.digitize.batch;

import java.util.Date;

import javax.batch.api.AbstractBatchlet;
import javax.batch.api.BatchProperty;
import javax.inject.Inject;

public class LoadMailData extends AbstractBatchlet 
{
    @Inject
    @BatchProperty(name = "runAt")
    Date runAt;
    /**
     * @see AbstractBatchlet#AbstractBatchlet()
     */
    public LoadMailData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
     * @see AbstractBatchlet#process()
     */
    public String process() 
    {

			return null;
    }

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		super.stop();
	}

}
