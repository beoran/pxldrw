# Wrapper around the layout classes, in a module. 
# Layout::Grid feels more natural in Ruby than GridLayout.
#
 
require 'slide/wrapper'

module Yagui
  module Layout    
    class Grid
      include Yagui::Wrapper
      attr_reader :rows
      attr_reader :cols
      def initialize(rows = 1, columns = 1)
        @rows  = rows
        @cols  = columns
        @swing = Awt::GridLayout.new(@rows, @cols)
      end      
    end        
  end
end
