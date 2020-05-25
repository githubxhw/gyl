package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 该类是父配置类来替换bean.xml
 */
@Configuration /*说明该类为是一个配置类*/
@ComponentScan(value = "com.itxhw") /*指示要扫描的文件*/
@Import(JdbcConfig.class)
public class MainConfig {
}
