/*** BEGIN META {
      "name" : "List all last build from all jobs",
      "comment" : "List <b>all last build</b> from <b>all jobs</b> in your Jenkins server",
      "parameters" : [],
      "core": "1.300",
      "authors" : [
        { name : "zhaoace - https://github.com/zhaoace" }
      ]
    } END META**/
import hudson.model.*
def items = Hudson.instance.allItems

items.each { item ->

  if (item instanceof Job) {

    def builds = item.getLastBuild()

    builds.each { build ->
      def since = groovy.time.TimeCategory.minus( new Date(), build.getTime() )
      def status = build.getBuildStatusSummary().message
      println "Build: ${build} | Since: ${since} | Status: ${status}" 
    }
  }
}
return
