package com.ahead.smartlock.core.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 对象转换工具类
 *
 * @author zqh
 */
public final class DataConverterUtils {
    /**
     * 支持对象集合
     */
    public static <F, T> List<T> convert(List<F> sourceList, Class<T> targetClz) {
        if (null != sourceList && 0 != sourceList.size()) {
            List<T> ret = new ArrayList<T>();
            for (F source : sourceList) {
                ret.add(convert(source, targetClz));
            }
            return ret;
        }
        return new ArrayList<T>();
    }

    public static <F, T> T convert(F source, Class<T> targetClz) {
        if (null == source) {
            return null;
        }
        try {
            T target = targetClz.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (IllegalAccessException | InstantiationException | ExceptionInInitializerError
                | SecurityException e) {
            throw new RuntimeException(
                    "failed to create instance of " + targetClz.getName() + " - " + e.getMessage(), e);
        }
    }

    public static <F, T> Page<T> convertPage(List<T> list, Long page, Long size, Long count) {
        Page<T> result = new Page<>();
        result.setRecords(list);
        result.setCurrent(page);
        result.setSize(size);
        result.setTotal(count);
        return result;
    }

    /**
     * 分页数据类型 convert
     *
     * @param data      需要转换的数据
     * @param targetClz 类型
     * @param <T>       转换前
     * @param <F>       转换后
     * @return 结果
     */
    public static <T, F> Page<F> convertPage(Page<T> data, Class<F> targetClz) {
        Page<F> responsePage = new Page<>();
        responsePage.setRecords(DataConverterUtils.convert(data.getRecords(), targetClz));
        responsePage.setTotal(data.getTotal());
        responsePage.setSize(data.getSize());
        responsePage.setCurrent(data.getCurrent());
        return responsePage;
    }

    /**
     * 将对象装换为map
     *
     * @param bean 实体对象
     * @return map
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }
}