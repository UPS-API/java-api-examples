package com.ups.api.app.tool;

import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTRequestWrapper;
import com.ups.api.app.AppConfig;

public interface CreateRequestEnricher {
	public default <T> T enrich(final AppConfig appConfig, T aT) {
		    	if(aT instanceof PAPERLESSDOCUMENTRequestWrapper) {
		    		PAPERLESSDOCUMENTRequestWrapper paperlessRequestWrapper = (PAPERLESSDOCUMENTRequestWrapper)aT;
				    paperlessRequestWrapper.getPushToImageRepositoryRequest().getFormsHistoryDocumentID().setDocumentID(appConfig.getDocumentId());
		    	}
		 return aT;
	}
}
