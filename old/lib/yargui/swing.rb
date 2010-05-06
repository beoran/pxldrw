#
# This module is used to import java Swing for easy use
#


require 'java'
   

module Swing
  include_package 'javax.swing'
  include_package 'javax.swing.event'
  # JOptionPane     = javax.swing.JOptionPane
  # JInternalFrame  = javax.swing.JInternalFrame
  # JFrame          = javax.swing.JFrame
  
end

