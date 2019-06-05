package community.isomorphic.iscserver.servlet

import com.isomorphic.servlet.DataSourceLoader
import org.springframework.core.annotation.Order
import javax.servlet.annotation.WebServlet

@WebServlet(loadOnStartup = 1, urlPatterns = ["/sc/DataSourceLoader", "/isomorphic/DataSourceLoader"])
@Order(value = ORDER_DATASOURCE_LOADER)
class CommunityDataSourceLoader : DataSourceLoader()