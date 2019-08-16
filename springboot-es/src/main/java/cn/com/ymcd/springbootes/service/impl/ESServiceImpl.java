package cn.com.ymcd.springbootes.service.impl;

import cn.com.ymcd.springbootes.dto.EmployeeDTO;
import cn.com.ymcd.springbootes.service.ESService;
import cn.com.ymcd.springbootes.vo.EmployeeVO;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: springboot-es
 * @author: dengp
 * @date: 2019年08月15日 15:14
 * @version: 1.0
 */
@Service
public class ESServiceImpl implements ESService {

    private static final Logger logger = LoggerFactory.getLogger(ESServiceImpl.class);

    @Autowired
    private RestHighLevelClient client;


    /**
     *
     * @param employeeVO
     */
    public void save(@RequestBody EmployeeVO employeeVO) {

    }

    /**
     *
     * @return
     */
    @Override
    public List<EmployeeDTO> query(@RequestBody EmployeeVO employeeVO) {

        List<EmployeeDTO> list = new ArrayList<>();
        try {
            SearchRequest searchRequest = new SearchRequest("megacorp");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            QueryBuilder matchQueryBuilder = QueryBuilders.rangeQuery("age").gte(employeeVO.getAge());
            SearchSourceBuilder query = searchSourceBuilder.query(matchQueryBuilder);


            searchSourceBuilder.from(0);
            searchSourceBuilder.size(5);

            searchRequest.source(searchSourceBuilder);
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

            System.out.println("searchRequest = " + searchRequest);
            System.out.println("query = " + query);

            System.out.println("searchResponse = " + searchResponse);

            //查询响应中取出结果
            SearchHits hits = searchResponse.getHits();
            SearchHit[] searchHits = hits.getHits();

            for (SearchHit hit : searchHits) {
                System.out.println(hit.getSourceAsString());

                EmployeeDTO employeeDTO = JSON.parseObject(hit.getSourceAsString(), EmployeeDTO.class);
                list.add(employeeDTO);
            }
        } catch (IOException e) {
            logger.error(e.toString());
        }
        return list;
    }

    @Override
    public List<EmployeeDTO> queryAll() {

        List<EmployeeDTO> list = new ArrayList<>();
        SearchRequest searchRequest = new SearchRequest("megacorp");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        QueryBuilder query = searchSourceBuilder.query();

        searchSourceBuilder.from(0);
        searchSourceBuilder.size(5);

        try {
            searchRequest.source(searchSourceBuilder);
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

            SearchHits hits = searchResponse.getHits();
            SearchHit[] hits1 = hits.getHits();

            for(SearchHit str : hits1){
                EmployeeDTO employeeDTO = JSON.parseObject(str.getSourceAsString(), EmployeeDTO.class);
                list.add(employeeDTO);
            }

        }catch (IOException e){


        }


        return list;
    }
}
