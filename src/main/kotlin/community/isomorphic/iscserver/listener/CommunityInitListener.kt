package community.isomorphic.iscserver.listener

import com.isomorphic.base.InitListener
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import javax.servlet.annotation.WebListener

@WebListener
@Order(value = Ordered.LOWEST_PRECEDENCE)
class CommunityInitListener : InitListener()