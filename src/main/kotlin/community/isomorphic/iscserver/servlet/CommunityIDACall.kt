package community.isomorphic.iscserver.servlet

import com.isomorphic.servlet.IDACall
import org.springframework.core.annotation.Order
import javax.servlet.annotation.WebServlet

@WebServlet(urlPatterns = ["/sc/IDACall/*", "/isomorphic/IDACall/*"])
@Order(value = ORDER_IDA_CALL)
class CommunityIDACall : IDACall()