import com.example.LogUtil;

module demo.six {
    provides java.lang.System.LoggerFinder
            with LogUtil.MyLogFinder;
}