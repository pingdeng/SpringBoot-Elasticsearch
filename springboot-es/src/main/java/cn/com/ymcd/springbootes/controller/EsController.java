package cn.com.ymcd.springbootes.controller;

import cn.com.ymcd.springbootes.dto.EmployeeDTO;
import cn.com.ymcd.springbootes.service.ESService;
import cn.com.ymcd.springbootes.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @projectName: springboot-es
 * @author: dengp
 * @date: 2019年08月13日 17:31
 * @version: 1.0
 */
@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private ESService esService;

    /**
     * 功能描述:
     * @author: dengp
     * @dateTime: 2019/8/15 0015 15:51
     * @param:
     * @return:
     */
    @RequestMapping("/query")
    public List<EmployeeDTO> query(@RequestBody EmployeeVO employeeVO){
        return esService.query(employeeVO);
    }
    
    /**
     * 功能描述:
     * @author: dengp
     * @dateTime: 2019/8/15 0015 16:40
     * @param:
     * @return: 
     */
    @RequestMapping("/queryAll")
    public List<EmployeeDTO> queryAll(){
        return esService.queryAll();
    }


}
