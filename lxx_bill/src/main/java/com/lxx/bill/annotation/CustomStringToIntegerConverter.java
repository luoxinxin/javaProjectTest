package com.lxx.bill.annotation;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.lxx.bill.enumbean.StringToIntegerConverterEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

/**
 * @Author husky
 * @Date 2022/3/15 10:52
 * @Description: 自定义指定字符串转指定数字转换器
 **/
@Slf4j
public class CustomStringToIntegerConverter implements Converter<Integer> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里是读的时候会调用
     *
     * @return
     */
    @Override
    public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        // 默认返回 0
        Integer result = 0;
        try{
            StringToIntegerConverterAnnotation annotation = contentProperty.getField().getAnnotation(StringToIntegerConverterAnnotation.class);
            if(annotation != null){
                //获取Excel中读取的数据
                String stringValue = cellData.getStringValue();

                //获取的String类型数据不为空
                if(!ObjectUtils.isEmpty(stringValue)){

                    //获取属性上的注解中传递的枚举值
                    StringToIntegerConverterEnum[] stringToIntegerConverterEnums = annotation.converterEnums();

                    //判断注解中枚举值真实存在
                    if(stringToIntegerConverterEnums != null){

                        //遍历注解中传递的枚举值
                        for(StringToIntegerConverterEnum stice:stringToIntegerConverterEnums){

                            //如果 Excel中读取的数据 与 传递的枚举中数据匹配
                            boolean intFlag = stice.getKey().equals(stringValue);
                            if(intFlag){

                                //返回值为枚举值配置的返回数字
                                result = stice.getValue();
                            }
                        }
                    }
                }
            }else{
                log.error("使用自定义字符串转数字转换器，缺少配套注解@StringToIntegerConverterAnnotation");
            }
        }catch (Exception e){
            log.error("使用自定义字符串转数字转换器，获取属性反射异常。Exception={}",e);
        }
        return result;
    }

    /**
     * 这里是写的时候会调用
     * @return
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Integer> context) {

        String result = "";
        try{
            StringToIntegerConverterAnnotation annotation = context.getContentProperty().getField().getAnnotation(StringToIntegerConverterAnnotation.class);
            if(annotation != null){
                //获取带写入Excel中数据
                int intValue = context.getValue();

                //获取的String类型数据不为空
                if(!ObjectUtils.isEmpty(intValue)){

                    //获取属性上的注解中传递的枚举值
                    StringToIntegerConverterEnum[] stringToIntegerConverterEnums = annotation.converterEnums();

                    //判断注解中枚举值真实存在
                    if(stringToIntegerConverterEnums != null){

                        //强烈建议！！！枚举值不要重复，如果重复则取最后一个
                        //遍历注解中传递的枚举值
                        for(StringToIntegerConverterEnum stice:stringToIntegerConverterEnums){

                            //如果 Excel中读取的数据 与 传递的枚举中数据匹配
                            boolean intFlag = stice.getValue() == intValue;
                            if(intFlag){

                                //返回值为枚举中配置的key
                                result = stice.getKey();
                            }
                        }
                    }
                }
            }else{
                log.error("使用自定义字符串转数字转换器，缺少配套注解@StringToIntegerConverterAnnotation");
            }
        }catch (Exception e){
            log.error("使用自定义字符串转数字转换器，获取属性反射异常。Exception={}",e);
        }
        return new WriteCellData<>(result);
    }
}
