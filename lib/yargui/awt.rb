#
# This module is used to import java AWT for easy use
#

require 'java'
module Yargui
  module Awt
    include_package 'java.awt'
    include_package 'java.awt.event'
    include_package  'java.awt.image'
  end # module Awt
end # module Yargui

