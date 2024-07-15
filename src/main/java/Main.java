import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author shenjies88
 * @since 2021-11-07-9:58
 */
public class Main {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/db_storage", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("heming") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()//禁止打开文件夹
                            .outputDir("D:\\workspace\\generator\\out"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("org.example") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\workspace\\generator\\out")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> builder.addInclude("storage_tbl")// 设置需要生成的表名
                        .entityBuilder()
                        .enableLombok()//开启lombok
                        .controllerBuilder()
                        .enableRestStyle()//RestController
                        .mapperBuilder()
                        .enableMapperAnnotation()
                        .build())
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
