
 

module Yargui
  # wrapper fos some
  module Wrapper
    
    # Class function to check self and return the matching AWT/Swing
    # component
    def self.to_gui_component()
      if self.is_a? Awt::Component
        return self
      elsif self.is_a? Swing::JComponent
        return self
      elsif self.respond_to? :to_swing
        # Otherwise, try to get the .to_swing value
        return self.swing
      else 
        return nil
      end      
    end
    
    
    attr_reader :to_swing
    def initialize
      super()
      @swing = nil
    end
    
    def add_child(other)
      component = other.to_gui_component
      if component
        self.getContentPane().add(component)
      else 
        raise "Cannot add #{other} to this UI element."
      end      
    end
=begin
    def resize(*sizes)
      w = sizes.shift
      return unless w
      h = sizes.shift || w
      self.setSize(w, h)
    end
=end
    # Enables mouse handling
    def enable_mouse
      return @mouse if @mouse
      @mouse ||= Yargui::Mouse::Adapter.new
      self.addMouseListener(@mouse)
      self.addMouseMotionListener(@mouse)
      return @mouse
    end
    
    # Gets the mouse handler. 
    def mouse_handler
      return enable_mouse
    end

    # Easier alias to the mouse handler
    def mouse
      return mouse_handler
    end
    
    # Enables action handling
    def enable_action(name = :action, block = nil)
      sname = name.to_sym
      return @action[sname] if (@action and @action[sname])
      @action       ||= {} 
      @action[sname]  = Yargui::Action::Adapter.new(sname)
      if block
        @action[sname].action do |act| block.call(act) end
      end
      @swing.addActionListener(@action[sname])
      return @action[sname]
    end
    
    # Gets the action handler for this action name (:action) by default. 
    def action(name=:action, &block)
      return enable_action(name, block) 
    end

    
    
    def next_to(other)
      @swing.setLocationRelativeTo(other.swing)
    end
    
  end
end
