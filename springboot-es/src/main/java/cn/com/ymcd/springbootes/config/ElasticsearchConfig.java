package cn.com.ymcd.springbootes.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @projectName: springboot-es
 * @author: dengp
 * @date: 2019年08月13日 17:24
 * @version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.es")
public class ElasticsearchConfig {

    /**
     * 连接ES的IP地址
     */
    @Value("${spring.es.host}")
    private String host;
    /**
     *
     *连接ES的端口
     */
    @Value("${spring.es.port}")
    private Integer port;

    /**
     * 连接ES的协议 http协议
     */
    @Value("${spring.es.scheme}")
    private String scheme;
    @Bean
    public RestHighLevelClient client()  {
        // 设置es节点的配置信息
       /**
        * 在Elasticsearch 7.0.0 版本字后改配置已经过时不建议使用，
        * 在Elasticsearch 8.0.0 版本中删除该方法的客户端的连接，
        * 在Elasticsearch 7.0.0 版本中是通过TCP协议进行连接的，默认端口是9300，
        * 而且需要在Elasticsearch中的 config/elasticsearch.yml文静中指定集群名称， 或者将默认的集群注释放开
        * 以上说明仅供参考。
        *
        * 官方建议使用下面配置方式创建Elasticsearch客户端连接

       Settings settings = Settings.builder()
                .put("cluster.name", "my-application")
                .build();

        // 实例化es的客户端对象
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

         */
        // 创建客户端连接ES 创建Bean对象, 当有多个集群时 可以创建多个 HttpHost, 指定不同的集群地址，本文只是为了学习只做了单实例的安装
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host, port, scheme)
                        ));
        return client;
    }
}



