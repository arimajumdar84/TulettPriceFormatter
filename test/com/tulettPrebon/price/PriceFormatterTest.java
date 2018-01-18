package com.tulettPrebon.price;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class PriceFormatterTest {

	@Test
	public void formatPrice() {
		
		TulettPriceFormatter tulettPriceFormatter = new TulettPriceFormatter();
		BigDecimal rawPrice = new BigDecimal("0.16754");
		Price finalPrice = tulettPriceFormatter.getPriceCalc(testPriceObj(DisplayFormat.PERCENTAGE), rawPrice);
		System.out.println("#############Final Output##############");
		System.out.println("Final Price "+finalPrice.getBigFigure());
		System.out.println("Fractional Pips "+finalPrice.getFractionalPips());
		System.out.println("Dealing Price "+finalPrice.getDealingPrice());
		assertEquals(new BigDecimal("16.7"), finalPrice.getBigFigure());
		
	}
	
	@Test(expected = ArithmeticException.class)
	public void formatPriceException() {
		TulettPriceFormatter tulettPriceFormatter = new TulettPriceFormatter();
		BigDecimal rawPrice = new BigDecimal("0.16754");
		Price finalPrice = tulettPriceFormatter.getPriceCalc(testPriceObj(DisplayFormat.DECIMAL), rawPrice);
		System.out.println("#############Final Output##############");
		assertEquals(new BigDecimal("16.7"), finalPrice.getBigFigure());
	}
	
	//Create a sample test object
	private Configuration testPriceObj(DisplayFormat ds) {
		Configuration configuration = new Configuration();
		configuration.setDisplayFormat(ds.getFormatValue());
		configuration.setDpl(1);
		configuration.setFpl(2);
		configuration.setScale(4);
		return configuration;
		
	}
}
