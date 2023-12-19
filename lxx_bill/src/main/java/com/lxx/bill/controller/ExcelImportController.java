package com.lxx.bill.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.fastjson2.JSON;
import com.lxx.bill.bean.AjaxResult;
import com.lxx.bill.bean.excel.*;
import com.lxx.bill.bean.DownloadData;
import com.lxx.bill.dao.AliUploadDAO;
import com.lxx.bill.dao.WechatUploadDAO;
import com.lxx.bill.dao.bank.CITICUploadDAO;
import com.lxx.bill.dao.bank.MerchantsUploadDAO;
import com.lxx.bill.dao.bank.PuFaUploadDAO;
import com.lxx.bill.listener.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/excel/")
public class ExcelImportController {

    @Autowired
    private AliUploadDAO aliUploadDAO;

    @Autowired
    private WechatUploadDAO wechatUploadDAO;

    @Autowired
    private PuFaUploadDAO puFaUploadDAO;

    @Autowired
    private MerchantsUploadDAO merchantsUploadDAO;

    @Autowired
    private CITICUploadDAO citicUploadDAO;

    /**
     * 文件上传
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link AliBillStreamUploadData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link AliUploadDataListener}
     * <p>
     * 3. 直接读即可
     */
    @PostMapping("aliUpload")
    @ResponseBody
    public AjaxResult aliUpload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), AliBillStreamUploadData.class, new AliUploadDataListener(aliUploadDAO)).sheet().doRead();
        return AjaxResult.success();
    }

    @PostMapping("wechatUpload")
    @ResponseBody
    public AjaxResult wechatUpload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), WechatBillStreamUploadData.class, new WechatUploadDataListener(wechatUploadDAO)).sheet().doRead();
        return AjaxResult.success();
    }

    @PostMapping("puFaUpload")
    @ResponseBody
    public AjaxResult puFaUpload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), PuFaBillStreamUploadData.class, new PuFaUploadDataListener(puFaUploadDAO)).sheet().doRead();
        return AjaxResult.success();
    }

    @PostMapping("merchantsUpload")
    @ResponseBody
    public AjaxResult merchantsUpload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), MerchantsBillStreamUploadData.class, new MerchantsUploadDataListener(merchantsUploadDAO)).sheet().doRead();
        return AjaxResult.success();
    }

    @PostMapping("citicsUpload")
    @ResponseBody
    public AjaxResult citicsUpload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), CITICBillStreamUploadData.class, new CITICUploadDataListener(citicUploadDAO)).sheet().doRead();
        return AjaxResult.success();
    }


}
