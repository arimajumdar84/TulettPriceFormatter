package com.tulettPrebon.price;

import java.math.BigDecimal;

public class TulettPriceFormatter implements PriceInterface{

	@Override
	public Price getPriceCalc(Configuration configuration, BigDecimal rawPrice) {
		// TODO Auto-generated method stub
		Price finalPrice = new Price();
		
		//Code to be parameterized
		int displayFormat = configuration.getDisplayFormat();
		int dpl = configuration.getDpl();
		int fpl = configuration.getFpl();
		int scale = configuration.getScale();
		
		BigDecimal rawPriceScale = rawPrice.multiply(new BigDecimal(displayFormat)).setScale(scale);
		
		//System.out.println("Raw Price scale "+rawPriceScale);
		
		String rawPriceScaleStr = rawPriceScale.toString();
		
		String fplStr = rawPriceScaleStr.substring(rawPriceScaleStr.length() - fpl, rawPriceScaleStr.length());
		//Strip trailing zeroes of fractional pips.
		BigDecimal fplWithoutZeros = new BigDecimal(fplStr).stripTrailingZeros(); 
		
		//System.out.println("FPL Str "+fplStr);
		
		String newStr = rawPriceScaleStr.replaceAll(fplStr, "");
		//System.out.println("New Str "+newStr);
		
		int dplIdx = new BigDecimal(newStr).scale();
		//System.out.println("Last index of "+dplIdx);
		
		String dplStr = null;
		if(dplIdx > dpl) {
			dplStr = newStr.substring(newStr.length() - dpl, newStr.length());
		} else {
			dplStr = newStr.substring(newStr.length() - dpl - 1, newStr.length());
		}
		//System.out.println("DPL Str "+dplStr);
		
		String priceStr = newStr.replaceAll(dplStr, "");
		//System.out.println("Price Str "+priceStr);
		
		finalPrice.setFractionalPips(new BigDecimal(fplWithoutZeros.toPlainString()));
		finalPrice.setDealingPrice(new BigDecimal(dplStr));
		finalPrice.setBigFigure(new BigDecimal(priceStr));
		
		return finalPrice;
	}
	
	

}
