
package tt.badu.ui.master;

import java.util.List;
import core.reporter.Vulnerability;

/**
 *
 * @author mk
 */
public interface MasterCallback {
    public void updateVulnerabilities(List<Vulnerability> selectedVulnerabilities);
}
