package com.ahead.smartlock.manage.controller.school;

import com.ahead.smartlock.core.response.Result;
import com.ahead.smartlock.core.response.ResultPage;
import com.ahead.smartlock.core.utils.DataConverterUtils;
import com.ahead.smartlock.manage.entity.User;
import com.ahead.smartlock.manage.params.VerifyUserPageFilterParam;
import com.ahead.smartlock.manage.params.VerifyUserUpdateParam;
import com.ahead.smartlock.manage.response.VerifyUserResponse;
import com.ahead.smartlock.manage.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author zqh
 * @description 身份认证控制器
 */
@Api(tags = "【学校管理】身份认证")
@RestController
@RequestMapping("/verify/user")
public class VerifyUserController {

    @Resource
    private IUserService iUserService;

    @GetMapping("/page/{page}/{size}")
    @ApiOperation(value = "分页查询用户身份认证列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数", paramType = "path", required = true, dataTypeClass = Long.class),
            @ApiImplicitParam(name = "size", value = "每页条数", paramType = "path", required = true, dataTypeClass = Long.class)}
    )
    public ResultPage<VerifyUserResponse> getPage(@PathVariable(value = "page") Long page,
                                                  @PathVariable(value = "size") Long size,
                                                  VerifyUserPageFilterParam filterParam) {
        return ResultPage.success(iUserService.getPage(page, size, filterParam));
    }

    @PostMapping("/batch/update")
    @ApiOperation(value = "批量修改/审批")
    public Result<Boolean> batchUpdate(@Valid @RequestBody List<VerifyUserUpdateParam> verifyUserUpdateParams) {
        return Result.success(iUserService.updateBatchById(DataConverterUtils.convert(verifyUserUpdateParams, User.class)));
    }

    @PostMapping("/update")
    @ApiOperation(value = "单个修改/审批")
    public Result<Boolean> update(@Valid @RequestBody VerifyUserUpdateParam verifyUserUpdateParam) {
        return Result.success(iUserService.updateById(DataConverterUtils.convert(verifyUserUpdateParam, User.class)));
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "id", value = "ID", type = "path", required = true, dataTypeClass = String.class)
    public Result<Boolean> delete(@Valid @PathVariable("id") String id) {
        return Result.success(iUserService.removeById(id));
    }
}
