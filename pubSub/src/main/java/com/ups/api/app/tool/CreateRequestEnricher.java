package com.ups.api.app.tool;

import com.ups.api.app.AppConfig;

public interface CreateRequestEnricher {
	public default <T> T enrich(final String scenarioName, final AppConfig appConfig, T aT) {
		 return aT;
	}
	

}
