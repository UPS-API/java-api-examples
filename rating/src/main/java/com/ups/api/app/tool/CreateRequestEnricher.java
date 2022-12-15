package com.ups.api.app.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openapitools.rate.client.model.DeliveryTimeInformationPickup;
import org.openapitools.rate.client.model.RATERequestWrapper;

import com.ups.api.app.AppConfig;


public interface CreateRequestEnricher {
	public default <T> T enrich(final String scenarioName, final AppConfig appConfig, T aT) {
		if(AppConfig.TNT_RATE_SCENARIO.equals(scenarioName) && aT instanceof RATERequestWrapper) {
 			RATERequestWrapper requestWrapper = (RATERequestWrapper)(aT);
 			if(requestWrapper.getRateRequest().getShipment().getDeliveryTimeInformation() == null ||
 					requestWrapper.getRateRequest().getShipment().getDeliveryTimeInformation().getPickup() == null) {
 				return aT;
 			}
 			final DeliveryTimeInformationPickup pickupInfo = requestWrapper.getRateRequest().
																				getShipment().
																				getDeliveryTimeInformation().
																				getPickup();
 			if(null != pickupInfo) {	 			
		 			Calendar cal = new GregorianCalendar();
		 			Util.dayRoll(cal, appConfig.getNumberOfDayFromToday());
		 			
		 			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		 			pickupInfo.setDate(dateFormat.format(cal.getTime()));
 			}
		 }
		 return aT;
	}
}
