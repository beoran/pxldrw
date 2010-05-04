# 
# To change this template, choose Tools | Templates
# and open the template in the editor.
 

require 'slide'
require 'swing'

module Yargui
  class Colorchooser 
    include Yargui::Wrapper
    include Yargui::Change::ColorModelHandler

    def initialize
      @swing = Swing::JColorChooser.new()
      enable_change
    end
  end # class Colorchooser
end # module Slide
