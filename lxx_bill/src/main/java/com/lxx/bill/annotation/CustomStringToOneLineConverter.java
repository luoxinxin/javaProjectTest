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
public class CustomStringToOneLineConverter implements Converter<String> {
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
    public String convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        String stringValue = null;
        try{
            StringToOneLineConverterAnnotation annotation = contentProperty.getField().getAnnotation(StringToOneLineConverterAnnotation.class);
            if(annotation != null){
                //获取Excel中读取的数据
                stringValue = cellData.getStringValue();
                //获取的String类型数据不为空
                if(!ObjectUtils.isEmpty(stringValue)) {
                    if (stringValue.contains("\n\r")) {
                        stringValue = stringValue.replace("\n\r", "");
                    }else if(stringValue.contains("\n")){
                        stringValue = stringValue.replace("\n", "");
                    }
                }
            }else{
                log.error("使用自定义字符串转数字转换器，缺少配套注解@StringToOneLineConverterAnnotation");
            }
        }catch (Exception e){
            log.error("使用自定义字符串转数字转换器，获取属性反射异常。Exception={}",e);
        }
        return stringValue;
    }

    
}
