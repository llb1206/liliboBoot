package com.Recursion;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class treeController {

    public static void main(String[] args) {
        RegionBeanTree beanTree1 = new RegionBeanTree();
        beanTree1.setCode("540000");
        beanTree1.setLable("西藏省");
        beanTree1.setPid("100000"); // 最高节点
        RegionBeanTree beanTree10 = new RegionBeanTree();
        beanTree10.setCode("440000");
        beanTree10.setLable("内蒙古");
        beanTree10.setPid("540000000"); // 最高节点
        RegionBeanTree beanTree11 = new RegionBeanTree();
        beanTree11.setCode("440001");
        beanTree11.setLable("呼伦贝尔");
        beanTree11.setPid("440000"); // 最高节点

        RegionBeanTree beanTree2 = new RegionBeanTree();
        beanTree2.setCode("540100");
        beanTree2.setLable("拉萨市");
        beanTree2.setPid("540000");
        RegionBeanTree beanTree3 = new RegionBeanTree();
        beanTree3.setCode("540300");
        beanTree3.setLable("昌都市");
        beanTree3.setPid("540000");
        RegionBeanTree beanTree4 = new RegionBeanTree();
        beanTree4.setCode("540121");
        beanTree4.setLable("林周县");
        beanTree4.setPid("540100");
        RegionBeanTree beanTree5 = new RegionBeanTree();
        beanTree5.setCode("540121206");
        beanTree5.setLable("阿朗乡");
        beanTree5.setPid("540121");
        RegionBeanTree beanTree6 = new RegionBeanTree();
        beanTree6.setCode("54012120001");
        beanTree6.setLable("那达村");
        beanTree6.setPid("540121206");
        List<RegionBeanTree> rootList = new ArrayList<>();
        rootList.add(beanTree1);
        rootList.add(beanTree10);
        List<RegionBeanTree> bodyList = new ArrayList<>();
        bodyList.add(beanTree1);
        bodyList.add(beanTree2);
        bodyList.add(beanTree3);
        bodyList.add(beanTree4);
        bodyList.add(beanTree5);
        bodyList.add(beanTree6);
        bodyList.add(beanTree11);
        bodyList.add(beanTree10);
        List<RegionBeanTree> result = getTree(rootList,bodyList);
        System.out.println(JSONObject.toJSON(result));
    }

    public static  List<RegionBeanTree> getTree(List<RegionBeanTree> rootList,List<RegionBeanTree> bodyList) {
        if (bodyList != null && !bodyList.isEmpty()) {
            Map<String, String> map = Maps.newHashMapWithExpectedSize(bodyList.size());
            rootList.forEach(beanTree -> getChild(beanTree, map,bodyList));
            return rootList;
        }
        return null;
    }

    public static void getChild(RegionBeanTree beanTree, Map<String, String> map,List<RegionBeanTree> bodyList) {
        List<RegionBeanTree> childList = Lists.newArrayList();
        bodyList.stream().filter(c -> !map.containsKey(c.getCode())).filter(c -> c.getPid().equals(beanTree.getCode()))
                .forEach(c -> {
                    map.put(c.getCode(), c.getPid());
                    getChild(c, map,bodyList);
                    childList.add(c);
                });
        beanTree.setChildren(childList);
    }
}