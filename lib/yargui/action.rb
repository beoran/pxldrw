#
# Transforms Swing action events into something more Rubyesque
#
 
module Yagui
  module Action
    # Adapter for swing action events
    class Adapter
    include Awt::ActionListener
    
      def initialize(name = :action)
        @name   = name
        @action = nil
      end

      def action(&block)
        @action = block     
      end

      def actionPerformed(event)
        if @action
          @action.call(@name)
        end
      end
      
    end
    
  end    
end
