# frozen_string_literal: true

require_relative "debug"

module IRB
  # :stopdoc:

  module Command
    class Next < DebugCommand
      def execute(*args)
        super(do_cmds: ["next", *args].join(" "))
      end
    end
  end

  # :startdoc:
end
