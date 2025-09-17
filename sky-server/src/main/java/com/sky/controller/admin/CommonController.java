package com.sky.controller.admin;


import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * general interfice
 */
@Slf4j
@RestController
@RequestMapping("/admin/common")
@Api(tags = "general interface")
public class CommonController {

    /**
     * Upload files
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("Upload files")
    public Result<String> upload(MultipartFile file){
        log.info("Upload file : {}",file);

        // inplement : need the cloud service

        return null;
    }

}
