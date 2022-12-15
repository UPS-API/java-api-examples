package com.ups.api.app.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openapitools.tnt.client.model.TimeInTransitRequest;

import com.ups.api.app.AppConfig;

public interface CreateRequestEnricher {
	public default <T> T enrich(final String scenarioName, final AppConfig appConfig, T aT) {
		 switch(scenarioName) {
		    case AppConfig.TNT_INTERNATIONAL_SUCCESS_SCENARIO:
		    case AppConfig.TNT_DOMESTIC_SUCCESS_SCENARIO:
		    	if(aT instanceof TimeInTransitRequest) {
		    		TimeInTransitRequest timeInTransitRequest = (TimeInTransitRequest)aT;
		    		if(null != timeInTransitRequest.getShipDate()) {
			    		Calendar cal = new GregorianCalendar();
			    		Util.dayRoll(cal, appConfig.getNumberOfDayFromToday());
	 
				        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				        final String dateString = dateFormat.format(cal.getTime());  
				        
				        timeInTransitRequest.setShipDate(dateString);
		    		}
		    	}
		    	break;
		    case AppConfig.TNT_INVALID_SHIP_DATE_SCENARIO:
		    	if(aT instanceof TimeInTransitRequest) {
		    		TimeInTransitRequest timeInTransitRequest = (TimeInTransitRequest)aT;
		    		if(null != timeInTransitRequest.getShipDate()) {
			    		Calendar cal = new GregorianCalendar();
			    		Util.dayRoll(cal, -35);
	 
				        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				        final String dateString = dateFormat.format(cal.getTime());  
				        
				        timeInTransitRequest.setShipDate(dateString);
		    		}
		    	}
		    	break;
		    default:
		    		break;
		 }
		 return aT;
	}
	

}
