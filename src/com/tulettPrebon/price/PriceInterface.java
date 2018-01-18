package com.tulettPrebon.price;

import java.math.BigDecimal;

public interface PriceInterface {

	public Price getPriceCalc(Configuration configuration, BigDecimal rawPrice);
}
