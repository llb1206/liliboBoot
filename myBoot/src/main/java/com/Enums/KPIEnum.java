package com.Enums;

public enum KPIEnum {

	/**
	 * 务必按着顺序来
	 */

    DEFAULT("default", "默认"),

    /*自营贷款-期限*/
    ZYDKQX1("HD000101018", "6个月以内"),

    ZYDKQX2("HD000101019", "6月至1年"),

    ZYDKQX3("HD000101021", "1至3年"),

    ZYDKQX4("HD000101022", "3至5年"),

    ZYDKQX5("HD000101023", "5年以上"),

    /*自营贷款-投向*/
    ZYDKTX1("HD000101001", "水电"),

    ZYDKTX2("HD000101002", "火电"),

    ZYDKTX3("HD000101003", "风电"),

    ZYDKTX4("HD000101004", "科工"),

    ZYDKTX5("HD000101005", "煤炭"),

    ZYDKTX6("HD000101006", "其他"),
    ;
    private String code;
    private String name;

    KPIEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }


    public static KPIEnum getTypeByCode(String code) {
        KPIEnum defaultType = KPIEnum.DEFAULT;
        for (KPIEnum type : KPIEnum.values()) {
            if (code.equals(type.code)) {
                return type;
            }
        }
        return defaultType;
    }

	public static void main(String[] args) {
		KPIEnum x = getTypeByCode("HD000101005");
		System.out.println(x.name);
	}

}



