package com.tulettPrebon.price;
import java.math.BigDecimal;

public class Price {

	DisplayFormat displayFormat;
	
	public BigDecimal bigFigure;
	
	public BigDecimal dealingPrice;
	
	public BigDecimal fractionalPips;

	
	public BigDecimal getBigFigure() {
		return bigFigure;
	}

	public void setBigFigure(BigDecimal bigFigure) {
		this.bigFigure = bigFigure;
	}

	public BigDecimal getDealingPrice() {
		return dealingPrice;
	}

	public void setDealingPrice(BigDecimal dealingPrice) {
		this.dealingPrice = dealingPrice;
	}

	public BigDecimal getFractionalPips() {
		return fractionalPips;
	}

	public void setFractionalPips(BigDecimal fractionalPips) {
		this.fractionalPips = fractionalPips;
	}
}
