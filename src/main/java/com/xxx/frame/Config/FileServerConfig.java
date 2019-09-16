package com.xxx.frame.Config;
import com.xxx.frame.Dao.TokenMapper;
import com.xxx.frame.Interceptor.ApiInterceptor;
import com.xxx.frame.Interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FileServerConfig extends WebMvcConfigurerAdapter {
    @Value("${local.fileserver.dir}")
    private String localFileServerDir;

    @Value("${local.fileserver.path}")
    private String localFileServerPath;

    //访问图片方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/" + this.getLocalFileServerPath() + "/**").addResourceLocations("file:" + this.getLocalFileServerDir() + "/");

        // 本地文件夹要以"flie:" 开头，文件夹要以"/" 结束，example：
        //registry.addResourceHandler("/abc/**").addResourceLocations("file:D:/pdf/");
        super.addResourceHandlers(registry);
    }

    /**
     * 文件实际路径转为服务器url路径
     * @param absolutePath
     * @return
     */
   /* public String toServerPath(String absolutePath) {
        absolutePath = absolutePath.replaceAll("\\\\", "/");
        return "/" + absolutePath.replace(localFileServerDir, localFileServerPath);
    }*/


    @Autowired
    private TokenMapper tokenMapper;

    public void addInterceptors(InterceptorRegistry registry){
        String [] exclude = {"/login","/markitup/**","/css/**","/email_templates/**","/font-awesome/**","/fonts/**","/img/**","/js/**","/LESS/**","*.html"};//后台页面    login以及静态资源不拦截
        String [] apiExclude = {"/api/login","/api/register"};
        //api接口拦截器
        registry.addInterceptor(new ApiInterceptor(tokenMapper)).addPathPatterns("/api/**")
                .excludePathPatterns(apiExclude);
        //后台管理系统拦截器
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/Manager/**")//设置拦截路径
                .excludePathPatterns(exclude);//设置放行路径
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }




















    public String getLocalFileServerDir() {
        return localFileServerDir;
    }

    public void setLocalFileServerDir(String localFileServerDir) {
        this.localFileServerDir = localFileServerDir;
    }

    public String getLocalFileServerPath() {
        return localFileServerPath;
    }

    public void setLocalFileServerPath(String localFileServerPath) {
        this.localFileServerPath = localFileServerPath;
    }
}