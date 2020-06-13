package com.retail.shoping.productservice.utils;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;

@Component
public class XoriskUtils {
    public static Date parseDate(String date, FastDateFormat format) {
        return parseDate(date, format.getPattern());
    }

    public static Date parseDate(String date, String pattern) {
        try {
            return DateUtils.parseDate(date, pattern);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static <T> T copySafe(Object src, T target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));

        return target;
    }

    public static <T> List<T> copySafe(List<?> srcLicopySafest, Class<T> targetType) {
        List<T> list = new ArrayList<>();
        for (Object src : srcLicopySafest) {
            T target;
            try {
                target = targetType.newInstance();
                list.add(copySafe(src, target));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    // public static void main(String[] args) {
    // Product product = new Product();
    // product.setName("Ms Office ");
    // product.setDescription("Ms Office Package");
    // product.setStandaloneProduct(true);
    // System.out.println(product);
    // ProductBean productBean = new ProductBean();
    // productBean.setPageUrl("http://microsoft.com");
    // copySafe(productBean, product);
    // System.out.println(product);
    // }

}
