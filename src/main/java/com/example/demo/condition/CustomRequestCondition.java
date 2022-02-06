package com.example.demo.condition;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wengjiadong
 */
public class CustomRequestCondition implements RequestCondition<CustomRequestCondition> {

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public CustomRequestCondition(String version) {
        this.version = version;
    }

    /**
     * when an interface has multiple rules, merge them
     * for example, specified on the class@RequestMappingThe URL of is root
     * And the@RequestMappingThe URL of ismethod.
     * In order to obtain the URL matching rules of this interface,
     * scan once on the class and once on the method.
     * At this time, you need to merge the two into one to indicate the interface matchingroot/method
     */
    @Override
    public CustomRequestCondition combine(CustomRequestCondition other) {
        return new CustomRequestCondition(other.version);
    }

    /**
     * judge whether it is successful or not,
     * and return null in case of failure;
     * otherwise, return the condition of matching success
     */
    @Override
    public CustomRequestCondition getMatchingCondition(HttpServletRequest request) {
        String apiVersion = request.getHeader("api-version");
        if (this.version.equals(apiVersion)) {
            return this;
        }
        return null;
    }

    @Override
    public int compareTo(CustomRequestCondition other, HttpServletRequest request) {
        return this.version.compareTo(other.version);
    }
}
