#
# Transforms Swing action events into something more Rubyesque
#
 
module Yargui
  module Action
    # Adapter for swing action events
    module Adapter
    include Awt::ActionListener
    
      def initialize(name = :action)
        super()
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
