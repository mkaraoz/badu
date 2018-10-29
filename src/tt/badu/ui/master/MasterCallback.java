/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
