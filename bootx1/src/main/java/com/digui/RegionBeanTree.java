package com.digui;
 
import lombok.Data;

import java.util.List;

@Data
public class RegionBeanTree {
	private int id;
	private String code;
	private String lable;
	private String pid;
	private List<RegionBeanTree> children;
 
    // 省略构造方法，get/set方法，toString方法
	
}