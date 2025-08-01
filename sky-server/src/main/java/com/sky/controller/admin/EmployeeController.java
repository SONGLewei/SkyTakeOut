package com.sky.controller.admin;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     *
     * @param employeeLoginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();

        return Result.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

    /**
     *
     * @param employeeDTO
     * @return
     */
    @PostMapping
    @ApiOperation("New employee 新员工")
    public Result save(@RequestBody EmployeeDTO employeeDTO){
        log.info("New employee :{}",employeeDTO);
        System.out.println("当前线程ID："+ Thread.currentThread().getId());
        employeeService.save(employeeDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("Pagination query of employee 员工分页查询")
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO){
        log.info("员工分页查询，参数为{}",employeePageQueryDTO);
        PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * Start or Close employee's account 禁止/启用账号
     * @param status
     * @param id
     * @return
     */
    @PostMapping ("/status/{status}")
    @ApiOperation("Start or Close employee's account 禁止/启用账号")
    public Result startOrStop(@PathVariable Integer status,Long id){
        log.info("启用，禁用员工账户:{},{}",status,id);
        employeeService.startOrStop(status,id);
        return Result.success();
    }

    /**
     * search by employee's ID 根据ID查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("search by employee's ID 根据ID查询员工信息")
    public Result<Employee> getById(@PathVariable Long id ){
        Employee employee = employeeService.getById(id);
        return Result.success(employee);
    }

    /**
     * @param employeeDTO
     * @return
     */
    @PutMapping
    @ApiOperation("Modify employee's info 编辑员工信息")
    public Result update(@RequestBody EmployeeDTO employeeDTO){
        log.info("编辑员工信息:{}",employeeDTO);
        employeeService.update(employeeDTO);
        return Result.success();
    }

}
