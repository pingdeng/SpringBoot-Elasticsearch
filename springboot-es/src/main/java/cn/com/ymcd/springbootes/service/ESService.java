package cn.com.ymcd.springbootes.service;

import cn.com.ymcd.springbootes.dto.EmployeeDTO;
import cn.com.ymcd.springbootes.vo.EmployeeVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: springboot-es
 * @author: dengp
 * @date: 2019年08月15日 15:08
 * @version: 1.0
 */
public interface ESService {

    /**
     * 功能描述: 查询数据
     * @author: dengp
     * @dateTime: 2019/8/15 0015 15:33
     * @param:
     * @return:
     */
    List<EmployeeDTO> query(EmployeeVO employeeVO);

    List<EmployeeDTO> queryAll();

}
