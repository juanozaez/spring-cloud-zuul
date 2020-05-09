package com.homelab.springcloudzuul

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

class LoggingFilter : ZuulFilter() {
    override fun filterType() = "pre"

    override fun filterOrder() = 1

    override fun shouldFilter() = true

    override fun run(): Any? {
        RequestContext.getCurrentContext().request.run {
            println("$method request to $requestURL")
        }
        return null
    }
}