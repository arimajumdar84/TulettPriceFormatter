package com.tulettPrebon.price;

public enum DisplayFormat {

	DECIMAL(1),
	PERCENTAGE(100),
	PER_MILE(1000),
	BASIS_POINT(10000);
	
	
	private final int formatValue;

    private DisplayFormat(int formatValue) {
        this.formatValue = formatValue;
    }

	public int getFormatValue() {
		return formatValue;
	}
    
   
	
}
