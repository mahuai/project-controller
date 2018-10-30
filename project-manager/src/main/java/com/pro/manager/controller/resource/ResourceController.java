package com.pro.manager.controller.resource;

import com.admin.api.entity.response.AdminResponseBean;
import com.base.result.BaseController;
import com.resource.api.entity.request.QueryRequest;
import com.resource.api.entity.response.FileResponse;
import com.resource.api.exception.ResourceManagerException;
import com.resource.api.service.ResourceManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.manager.controller.resource
 * @date: Created in 2018/9/13  10:39
 */
@Api(description = "resource manager", tags = "background manager")
@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private ResourceManagerService resourceManagerService;


    @ApiOperation(value = "get resource list", tags = {"background manager"}, notes = "get resource list", response = AdminResponseBean.class, code = 0)
    @ApiResponses({
            @ApiResponse(code = 200, message = "get success", response = AdminResponseBean.class)
    })
    @GetMapping("/getResourceList")
    public Object getResourceList() {
        List<FileResponse> fileList;
        try {
            fileList = resourceManagerService.getConditionsByFiles(null);
            if (fileList != null) {
                return returnSuccessResult(fileList);
            }
        } catch (ResourceManagerException e) {
            logger.error("get resource list error:", e);
        }
        return null;
    }

    @ApiOperation(value = "view image", tags = {"background manager"}, notes = "view image", response = ResponseEntity.class, code = 0)
    @ApiResponses({
            @ApiResponse(code = 200, message = "get success", response = ResponseEntity.class)
    })
    @GetMapping("/view")
    public ResponseEntity view(HttpServletResponse response) {
        FileResponse fileResponse = resourceManagerService.getObjectIdByFile(new QueryRequest("_id", "5b988c4298241209f4b6245c"));
        if (response != null) {
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + fileResponse.getFileName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, fileResponse.getContentType())
                    .header(HttpHeaders.CONTENT_LENGTH, fileResponse.getContentLength())
                    .header("Connection", "close")
                    .body(fileResponse.getContent());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File was not fount");
        }
    }


}
